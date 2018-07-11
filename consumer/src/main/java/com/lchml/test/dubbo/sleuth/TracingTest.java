package com.lchml.test.dubbo.sleuth;

import brave.Span;
import brave.Tracer;
import brave.Tracing;
import brave.dubbo.rpc.TracingFilter;
import brave.propagation.Propagation;
import brave.propagation.TraceContext;
import brave.propagation.TraceContextOrSamplingFlags;
import com.alibaba.dubbo.common.extension.ExtensionLoader;
import com.alibaba.dubbo.config.spring.extension.SpringExtensionFactory;
import com.alibaba.dubbo.remoting.exchange.ResponseCallback;
import com.alibaba.dubbo.rpc.*;
import com.alibaba.dubbo.rpc.protocol.dubbo.FutureAdapter;
import com.alibaba.dubbo.rpc.support.RpcUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import zipkin2.Endpoint;

import java.net.InetSocketAddress;
import java.util.Map;
import java.util.concurrent.Future;

/**
 * Created by lc on 2018/07/03.
 */
@Component
public class TracingTest {

    private Tracer tracer;
    private TraceContext.Extractor<Map<String, String>> extractor;
    private TraceContext.Injector<Map<String, String>> injector;

    /**
     * {@link ExtensionLoader} supplies the tracing implementation which must be named "tracing". For
     * example, if using the {@link SpringExtensionFactory}, only a bean named "tracing" will be
     * injected.
     */
    @Autowired
    public void setTracing(Tracing tracing) {
        tracer = tracing.tracer();
        extractor = tracing.propagation().extractor(GETTER);
        injector = tracing.propagation().injector(SETTER);
    }

    public String invoke() throws RpcException {
        return tracer.toString();
    }

    static void onError(Throwable error, Span span) {
        span.error(error);
        if (error instanceof RpcException) {
            span.tag("dubbo.error_code", Integer.toString(((RpcException) error).getCode()));
        }
    }

    static final Propagation.Getter<Map<String, String>, String> GETTER =
            new Propagation.Getter<Map<String, String>, String>() {
                @Override
                public String get(Map<String, String> carrier, String key) {
                    return carrier.get(key);
                }

                @Override
                public String toString() {
                    return "Map::get";
                }
            };

    static final Propagation.Setter<Map<String, String>, String> SETTER =
            new Propagation.Setter<Map<String, String>, String>() {
                @Override
                public void put(Map<String, String> carrier, String key, String value) {
                    carrier.put(key, value);
                }

                @Override
                public String toString() {
                    return "Map::set";
                }
            };

    static final class FinishSpanCallback implements ResponseCallback {
        final Span span;

        FinishSpanCallback(Span span) {
            this.span = span;
        }

        @Override public void done(Object response) {
            span.finish();
        }

        @Override public void caught(Throwable exception) {
            onError(exception, span);
            span.finish();
        }
    }
}

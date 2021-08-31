package com.GitHub.InvestApp.LoanServices;

import lombok.Value;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.data.cassandra.config.AbstractReactiveCassandraConfiguration;
import org.springframework.data.cassandra.config.SchemaAction;
import org.springframework.data.cassandra.core.cql.keyspace.CreateKeyspaceSpecification;
import org.springframework.data.cassandra.core.cql.keyspace.KeyspaceOption;
import org.springframework.data.cassandra.repository.config.EnableReactiveCassandraRepositories;
import org.springframework.http.MediaType;
import org.springframework.http.server.reactive.HttpHandler;
import org.springframework.http.server.reactive.ReactorHttpHandlerAdapter;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;
import org.springframework.web.server.adapter.WebHttpHandlerBuilder;
import reactor.netty.http.server.HttpServer;

import java.util.Arrays;
import java.util.List;

@Configuration
@ComponentScan
@EnableReactiveCassandraRepositories (basePackages = {"com.gitHub.vazidev.LoanServices.domain"})
public class CassandraConfig extends AbstractReactiveCassandraConfiguration  {

    @Override
    protected String getContactPoints(){
        return "localhost";
    }

    //@Override
    protected String getTableName(){
        return "loans";
    }


    /**

     public ReactiveCassandraTemplate reactiveCassandraTemplate(){
     return new ReactiveCassandraTemplate(reactiveCassandraTemplate().getReactiveCqlOperations(), getDatabaseName()) ;
     }

    @Value("${cassandra.keyspace}")
    private String keyspace;

    @Value("${cassandra.contactPoint}")
    private String contactPoint;

    @Value("${dbname}")
    private String dbName;

    @Value("${port}")
    private String port;

    protected String getDatabaseName() {
    return dbName;
    }
**/


    @Override
    protected String getKeyspaceName(){
        return "investapp"  ;
    }

    @Override
    public SchemaAction getSchemaAction() { return SchemaAction.CREATE_IF_NOT_EXISTS; }

    @Override
    protected List<CreateKeyspaceSpecification> getKeyspaceCreations(){
        CreateKeyspaceSpecification specs = CreateKeyspaceSpecification.createKeyspace("investapp")
                .ifNotExists()
                .withSimpleReplication()
                .with(KeyspaceOption.DURABLE_WRITES, true);
        return Arrays.asList(specs);
    }


    public HttpServer httpServer(ApplicationContext context){
        HttpHandler handler = WebHttpHandlerBuilder.applicationContext(context).build();
        ReactorHttpHandlerAdapter adapter = new ReactorHttpHandlerAdapter(handler);
        return HttpServer.create().port(8080).handle(adapter);
    }

  /**
    public RouterFunction<ServerResponse> indexRouter(@Value("classpath:LoanServices.html")Resource indexHtmlFile) {
        return RouterFunctions.route(RequestPredicates.GET("/"), request -> ServerResponse.ok().contentType(MediaType.TEXT_HTML).bodyValue(indexHtmlFile))
    }
**/
}

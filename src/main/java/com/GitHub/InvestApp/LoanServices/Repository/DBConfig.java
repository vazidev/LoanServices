package com.GitHub.InvestApp.LoanServices.Repository;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.cassandra.config.AbstractReactiveCassandraConfiguration;
import org.springframework.data.cassandra.config.SchemaAction;
import org.springframework.data.cassandra.core.cql.keyspace.CreateKeyspaceSpecification;
import org.springframework.data.cassandra.core.cql.keyspace.KeyspaceOption;
import org.springframework.data.cassandra.repository.config.EnableReactiveCassandraRepositories;

import java.util.Arrays;
import java.util.List;

@Configuration
@EnableReactiveCassandraRepositories
public class DBConfig  extends AbstractReactiveCassandraConfiguration {

    @Override
    protected String getKeyspaceName(){ return "investapp"; }

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


}

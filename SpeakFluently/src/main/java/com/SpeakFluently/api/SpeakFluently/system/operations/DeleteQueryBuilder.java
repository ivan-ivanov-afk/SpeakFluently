package com.SpeakFluently.api.SpeakFluently.system.operations;
import com.SpeakFluently.api.SpeakFluently.system.QueryProcessor;
public class DeleteQueryBuilder extends WhereQueryBuilder<DeleteQueryBuilder> {

    private QueryProcessor queryProcessor;
    private String tableName;

    public DeleteQueryBuilder(QueryProcessor queryProcessor, String tableName) {

        super(queryProcessor);
        this.queryProcessor = queryProcessor;
        this.queryProcessor.initNewQueryOperation();
        this.queryProcessor.getQueryBuilder().append("DELETE FROM ").append(tableName);
    }

    public int delete() {
        return this.queryProcessor.processQuery();
    }
}
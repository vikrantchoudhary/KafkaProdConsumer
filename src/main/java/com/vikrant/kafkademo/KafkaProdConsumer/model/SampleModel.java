package com.vikrant.kafkademo.KafkaProdConsumer.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class SampleModel {
    private int id;
    private String field1;
    private String field2;
    private String field3;
    public SampleModel(int id, String field1,String field2,String field3) {
        this.id = id;
        this.field1 = field1;
        this.field2 = field2;
        this.field3 = field3;
    }
}

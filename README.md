# KafkaProdConsumer
Basic demo for producer consumer code with kafka and spring boot. 

(Experimented with JDK11 and Kafka 2.6.0)

To run:

1. start Zookeeper : (cd to kafka folder)
> bin/zookeeper-server-start.sh config/zookeeper.properties
...
[2020-11-16 17:21:07,307] INFO Snapshotting: 0xa4 to /tmp/zookeeper/version-2/snapshot.a4 (org.apache.zookeeper.server.persistence.FileTxnSnapLog) /
[2020-11-16 17:21:07,327] INFO Using checkIntervalMs=60000 maxPerMinute=10000 (org.apache.zookeeper.server.ContainerManager) /
[2020-11-16 17:21:13,389] INFO Creating new log file: log.a5 (org.apache.zookeeper.server.persistence.FileTxnLog) /

2. Start Kafka Server: 
> bin/kafka-server-start.sh config/server.properties
...
[2020-11-16 19:53:37,936] INFO [GroupMetadataManager brokerId=0] Finished loading offsets and group metadata from __consumer_offsets-28 in 62 milliseconds, of which 62 milliseconds was spent in the scheduler. (kafka.coordinator.group.GroupMetadataManager) /
[2020-11-16 19:53:37,939] INFO [GroupCoordinator 0]: Stabilized group console-consumer-36350 generation 2 (__consumer_offsets-38) (kafka.coordinator.group.GroupCoordinator) /
[2020-11-16 19:53:37,996] INFO [GroupCoordinator 0]: Assignment received from leader for group console-consumer-36350 for generation 2 (kafka.coordinator.group.GroupCoordinator) /

3. Run the application : http://localhost:8080/

4. Test the application : 

using Postman app to test the producer service: 
POST : http://localhost:8080/api/kafka/sample

Input data

"
{
    "id" : 10,
    "field1" : "field1_datsa",
    "field2" : "field2_data",
    "field3" : "field3_data"
}
"

5. Check the created topic and message: 
> bin/kafka-console-consumer.sh --bootstrap-server localhost:9092 --topic mytopic

{"id":10,"field1":"field1_datsa","field2":"field2_data","field3":"field3_data"}

TODO: 
 Consumer app (in progress) 


# BDPZ CO.

## Spring Boot + Elasticsearch 7.10

*Docker-compose*

Build and run:

```
$ docker-compose up -d --build
```

Alternatively, run Elasticsearch apart with  _docker_ , for testing purposes:

```
$ docker run -d --rm --name elasticsearch \
	-e "discovery.type=single-node" \
	-v esdata:/usr/share/elasticsearch/data \
	-p 9200:9200 \
	docker.elastic.co/elasticsearch/elasticsearch:7.10.0
```

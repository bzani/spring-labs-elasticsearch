Run Elasticsearch on Docker:

```
docker run --rm -p 9200:9200 -e "discovery.type=single-node" \
	docker.elastic.co/elasticsearch/elasticsearch:7.10.0
```


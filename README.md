# OpenNLP Service

This java program provides RESTful API for [Apache OpenNLP](https://opennlp.apache.org/) library. 

### Notes:
- It is based on [Jersey](https://jersey.github.io/) and [Grizzly](https://javaee.github.io/grizzly/) frameworks. 

- Default binding address is: 0.0.0.0:80

- The web service consumes POST requests with raw data (`text/plain`) payload.

- At the moment, it only supports English language (through official [pre-trained models for the OpenNLP 1.5](http://opennlp.sourceforge.net/models-1.5/)).

## Quick Start

#### 1. Clone the repository:
```bash
$ git clone https://github.com/rbehzadan/opennlp-service.git
cd opennlp-service
```

#### 2. Download models (77MB):
```bash
$ mkdir models
$ cd models
$ wget -i ../models.url
$ cd ..
```

#### 3. Build:
```bash
$ mvn clean package
```

#### 4. Run:
```bash
$ java -jar target/opennlp-service-1.0.jar
```

#### 5. Use:
```bash
$ curl http://localhost -d "Grammar is useless because there is nothing to say."
```

### Changing binding address

You can change listening address and port by these two environment variables:
- `OPENNLP_SERVICE_HOST`
- `OPENNLP_SERVICE_PORT`

&nbsp;


## Output example

You can find some samples [here](docs/sample.md).

## Docker

#### Build:
```bash
$ cd opennlp-service
$ docker build -t opennlp .
```

#### Run:
```bash
$ docker run --name opennlp --rm -p 80:80 -d opennlp
```
To specify the listening port:
```bash
$ docker run -e OPENNLP_SERVICE_PORT=1234 -p 1234:1234 -d opennlp
```
If you're using Docker for Mac, you may have to specify a memory limit.
```bash
$ docker run --memory 4G -p 80:80 -d opennlp
```

## Licenses

- The project (**itself**), is licensed under the MIT License
- [Jersey](https://jersey.github.io/) and [Grizzly](https://javaee.github.io/grizzly/) are licensed under CDDL version 1.0 and GPL v2 license
- [Apache OpenNLP](https://opennlp.apache.org/) library is licensed under Apache 2.0 license

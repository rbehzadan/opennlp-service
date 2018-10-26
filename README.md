# OpenNLP Service

This java program provides RESTful API for [Apache OpenNLP](https://opennlp.apache.org/) library. 

### Notes:
- It is based on [Jersey](https://jersey.github.io/) and [Grizzly](https://javaee.github.io/grizzly/) frameworks. 

- The server binds to `TCP` port 6003 (Hard-Coded) on all available IPv4 addresses. 

- The web service consumes POST requests with raw data (`text/plain`) payload.

- At the moment, it only supports English language (through official [pre-trained models for the OpenNLP 1.5](http://opennlp.sourceforge.net/models-1.5/)).

## Quick Start

1. Clone the repository:
```bash
$ git clone https://github.com/rbehzadan/opennlp-service.git
cd opennlp-service
```

2. Download models:
```bash
$ mkdir models
$ cd models
$ wget -i ../models.url
$ cd ..
```

3. Build:
```bash
$ mvn clean package
```

4. Run:
```bash
$ java -jar target/opennlp-service-1.0.jar
```

5. Use:
```bash
$ curl -X POST http://localhost:6003/ -H "Content-Type: text/plain" -d "He died on Oct 25, 2018 at his office in United Nations building in New York."
```

## Output example
For the command above the [prettified] output would be like this:
```json
{
  "sentences": [
    {
      "body": "He died on Oct 25, 2018 at his office in United Nations building in New York.",
      "chunks": [
        {
          "body": "He",
          "end": 1,
          "label": "NP",
          "start": 0
        },
        {
          "body": "died",
          "end": 2,
          "label": "VP",
          "start": 1
        },
        {
          "body": "on",
          "end": 3,
          "label": "PP",
          "start": 2
        },
        {
          "body": "Oct 25 , 2018",
          "end": 7,
          "label": "NP",
          "start": 3
        },
        {
          "body": "at",
          "end": 8,
          "label": "PP",
          "start": 7
        },
        {
          "body": "his office",
          "end": 10,
          "label": "NP",
          "start": 8
        },
        {
          "body": "in",
          "end": 11,
          "label": "PP",
          "start": 10
        },
        {
          "body": "United Nations building",
          "end": 14,
          "label": "NP",
          "start": 11
        },
        {
          "body": "in",
          "end": 15,
          "label": "PP",
          "start": 14
        },
        {
          "body": "New York",
          "end": 17,
          "label": "NP",
          "start": 15
        }
      ],
      "namedEntities": [
        {
          "body": "Oct 25 , 2018",
          "end": 7,
          "label": "date",
          "start": 3
        },
        {
          "body": "New York",
          "end": 17,
          "label": "location",
          "start": 15
        },
        {
          "body": "United Nations",
          "end": 13,
          "label": "organization",
          "start": 11
        }
      ],
      "parses": [
        "(TOP (S (NP (PRP He)) (VP (VBD died) (PP (IN on) (NP (NNP Oct) (CD 25,) (CD 2018))) (PP (IN at) (NP (NP (PRP$ his) (NN office)) (PP (IN in) (NP (NP (NNP United) (NNPS Nations) (NN building)) (PP (IN in) (NP (NNP New)))))))) (. York.)))"
      ],
      "tokens": [
        {
          "body": "He",
          "partOfSpeech": "PRP"
        },
        {
          "body": "died",
          "partOfSpeech": "VBD"
        },
        {
          "body": "on",
          "partOfSpeech": "IN"
        },
        {
          "body": "Oct",
          "partOfSpeech": "NNP"
        },
        {
          "body": "25",
          "partOfSpeech": "CD"
        },
        {
          "body": ",",
          "partOfSpeech": ","
        },
        {
          "body": "2018",
          "partOfSpeech": "CD"
        },
        {
          "body": "at",
          "partOfSpeech": "IN"
        },
        {
          "body": "his",
          "partOfSpeech": "PRP$"
        },
        {
          "body": "office",
          "partOfSpeech": "NN"
        },
        {
          "body": "in",
          "partOfSpeech": "IN"
        },
        {
          "body": "United",
          "partOfSpeech": "NNP"
        },
        {
          "body": "Nations",
          "partOfSpeech": "NNPS"
        },
        {
          "body": "building",
          "partOfSpeech": "NN"
        },
        {
          "body": "in",
          "partOfSpeech": "IN"
        },
        {
          "body": "New",
          "partOfSpeech": "NNP"
        },
        {
          "body": "York",
          "partOfSpeech": "NNP"
        },
        {
          "body": ".",
          "partOfSpeech": "."
        }
      ]
    }
  ]
}
```

## Docker

- Build:
```bash
$ cd opennlp-service
$ docker build -t opennlp .
```

- Run:
```bash
$ docker run --name opennlp -p 6003:6003 -d opennlp
```

## Licenses

- The project (**itself**), is licensed under the MIT License
- [Jersey](https://jersey.github.io/) and [Grizzly](https://javaee.github.io/grizzly/) are licensed under CDDL version 1.0 and GPL v2 license
- [Apache OpenNLP](https://opennlp.apache.org/) library is licensed under Apache 2.0 license

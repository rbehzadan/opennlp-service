```bash
$ curl http://localhost:6003/ -d "He died on Oct 25, 2018 at his office in United Nations building in New York."
```

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


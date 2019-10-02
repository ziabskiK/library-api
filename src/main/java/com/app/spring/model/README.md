## Oczekiwany rezultat 

#### HTTPGET: .../author/1
```
{
  "id":1,
  
  "firstName":"imie",
  
  "lastName":"nazwisko",
  
  "books":[  
    "id":1,    
    "title":"Tytuł",    
    "genre":"Kryminał"    
    ]  
}
```

Analogicznie

#### GET: .../book/1
```
{

  "id":1,
  
  "title":"Tytuł",
  
  "genre":"Kryminał",
  
  "author":{
  
       "id":1,
       
       "firstName":"imie",
       
       "lastName":"nazwisko"
   }
   
}
```


### Jak jest?

#### GET:.../book/1

```
{
"id":1,
"title":"Tytuł,
"genre":"Kryminał",
"author":{
    "id":1,
    "firstName":"imie";
    "lastName":"nazwisko",
    "books":[
          "id":1,
          "title":"Tytuł,
          "genre":"Kryminał",
          "author":{
              "id":1,
              "firstName":"imie";
              "lastName":"nazwisko",
              "books":[
          ................
        ]
      ]
  }

}

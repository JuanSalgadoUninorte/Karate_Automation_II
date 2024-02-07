function fn(){
  karate.configure('connectTimeout', 5000);
  karate.configure('readTimeout', 5000);

  return {
    api: {
        baseUrl: "http://api.geonames.org/"
    },
    user: {
        name: 'Batman'
    }
  };
}
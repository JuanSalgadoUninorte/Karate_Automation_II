function fn(){
  karate.configure('connectTimeout', 5000);
  karate.configure('readTimeout', 5000);

  var baseUrl = karate.properties['baseUrl'] || 'http://api.geonames.org/'
  var user = karate.properties['user'] || 'Batman'

  return {
    api: {
        baseUrl: baseUrl
    },
    user: {
        name: user
    }
  };
}
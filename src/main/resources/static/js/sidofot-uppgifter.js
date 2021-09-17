fetch('../data/sidofotupppgifter.json')
      .then(function (response) 
      {
          return response.json();
      })
      .then(function (data) 
      {
          appendData(data);
      })
      .catch(function (err) 
      {
          console.log('error: ' + err);
      });
  function appendData(data) 
  {
      var mainContainer = document.getElementById("kontaktUppgifter");
      for (var i = 0; i < data.length; i++) 
      {
          var div = document.createElement("div");
          div.innerHTML =

              'E-mail: ' + '<a href="mailto:hakimlivs@mat.se">hakimlivs@mat.se</a>' +
              "<br/>" + 
              'Adress: ' + data[i].adress  + 
              "<br/>" + 
              'Telefon: ' +  data[i].telefon  + 
              "<br/>" + 
              'Öppettider: ' +  data[i].openhours;


          mainContainer.appendChild(div);
      }
  }

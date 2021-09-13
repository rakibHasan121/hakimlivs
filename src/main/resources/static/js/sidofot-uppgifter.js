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
              'E-mail: ' + data[i].mail + 
              "<br/>" + 
              'Adress: ' + data[i].adress  + 
              "<br/>" + 
              'Telefon: ' +  data[i].telefon  + 
              "<br/>" + 
              'Öppettider: ' +  data[i].openhours;


          mainContainer.appendChild(div);
      }
  }

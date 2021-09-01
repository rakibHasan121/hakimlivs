function pwdcheck(){
  var x1 = document.forms["myForm"]["firstname"];
  var nameRegex = /^[a-öA-Ö_ ]*$/;
  var x7 = document.forms["myForm"]["lastname"];
  var lastnameRegex = /^[a-öA-Ö_ ]*$/;
  var x2 = document.forms["myForm"]["email"];
  var emailRegex = /^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,6}$/;
  var x3 = document.forms["myForm"]["address"];
  var adressRegex = /^[a-öA-Ö0-9_ :]*$/;
  var x4 = document.forms["myForm"]["city"];
  var cityRegex = /^[a-öA-Ö]*$/;
  var x5 = document.forms["myForm"]["zipcode"];
  var zipRegex = /^\d{3} \d{2}$/;
  var x6 = document.forms["myForm"]["phonenumber"];
  var phoneRegex = /^[\-\0-9]*$/;

  
  if (x1.value == "") {
    alert("Du måste ange ditt namn");
   return false;
  } else if (!nameRegex.test(x1.value)) {
    alert("Felaktigt format på namn");
    return false;
  }

  if (x7.value == "") {
      alert("Du måste ange ditt efternamn");
      return false;
  } else if (!lastnameRegex.test(x7.value)) {
      alert("Felaktigt format på ditt efternamn");
      return false;
  }

  if (x3.value == "") {
    alert("Du måste ange din adress");
    return false;
  } else if (!adressRegex.test(x3.value)) {
    alert("Felaktigt format på adress");
    return false;
  }

  if (x5.value == "") {
    alert("Du måste ange ditt postnummer");
    return false;
  } else if (!zipRegex.test(x5.value)) {
    alert("Felaktigt format på postnummer, xxx xx");
    return false;
  }

  if (x4.value == "") {
    alert("Du måste ange din ort");
    return false;
  } else if (!cityRegex.test(x4.value)) {
    alert("Felaktigt format på ort");
    return false;
  }

  
  if (x6.value == "") {
    alert("Du måste ange ditt telefonnummer");
    return false;
  } else if (!phoneRegex.test(x6.value)) {
    alert("Felaktigt format på telefonnummer");
    return false;
  }
  

  if (x2.value == "") {
    alert("Du måste ange din email");
    return false;
  } else if (!emailRegex.test(x2.value)) {
    alert("Felaktigt format på email");
    return false;
  }
  return true;
} 




//Validation of phonenumber textfield (XXX-XXX XX XX)
var zChar = new Array(' ', '(', ')', '-', '.');
var maxphonelength = 15;  //13
var phonevalue1;
var phonevalue2;
var cursorposition;

function ParseForNumber1(object) {
    phonevalue1 = ParseChar(object.value, zChar);
}

function ParseForNumber2(object) {
    phonevalue2 = ParseChar(object.value, zChar);
}

function backspacerUP(object, e) {
    if (e) {
        e = e
    } else {
        e = window.event
    }
    if (e.which) {
        var keycode = e.which
    } else {
        var keycode = e.keyCode
    }

    ParseForNumber1(object)

    if (keycode >= 48) {
        ValidatePhone(object)
    }
}

function backspacerDOWN(object, e) {
    if (e) {
        e = e
    } else {
        e = window.event
    }
    if (e.which) {
        var keycode = e.which
    } else {
        var keycode = e.keyCode
    }
    ParseForNumber2(object)
}

function GetCursorPosition() {

    var t1 = phonevalue1;
    var t2 = phonevalue2;
    var bool = false
    for (i = 0; i < t1.length; i++) {
        if (t1.substring(i, 1) != t2.substring(i, 1)) {
            if (!bool) {
                cursorposition = i
                bool = true
            }
        }
    }
}

function ValidatePhone(object) {

    var p = phonevalue1

    p = p.replace(/[^\d]*/gi, "") 

    if (p.length < 3) {
        object.value = p
    } else if (p.length > 3 && p.length < 7) {
        //p = "(" + p;
        l30 = p.length;
        p30 = p.substring(0, 3);
        p30 = p30 + "-"

        p31 = p.substring(3, l30);
        pp = p30 + p31;

        object.value = pp;

    } else if (p.length >= 7) {
        //p = "(" + p;
        l30 = p.length;
        p30 = p.substring(0, 3);
        p30 = p30 + "-"

        p31 = p.substring(3, l30);
        pp = p30 + p31;

        l40 = pp.length;
        p40 = pp.substring(0, 7);
        p40 = p40 + " "

        p41 = pp.substring(7, 9);
        p42 = pp.substring(9,11);
        ppp = p40 + p41 + " " + p42;


        object.value = ppp.substring(0, maxphonelength);
    }

    GetCursorPosition()

    if (cursorposition >= 0) {
        if (cursorposition == 0) {
            cursorposition = 2
        } else if (cursorposition <= 2) {
            cursorposition = cursorposition + 1
        } else if (cursorposition <= 5) {
            cursorposition = cursorposition + 2
        } else if (cursorposition == 6) {
            cursorposition = cursorposition + 2
        } else if (cursorposition == 7) {
            cursorposition = cursorposition + 4
            e1 = object.value.indexOf(')')
            e2 = object.value.indexOf('-')
            if (e1 > -1 && e2 > -1) {
                if (e2 - e1 == 4) {
                    cursorposition = cursorposition - 1
                }
            }
        } else if (cursorposition < 11) {
            cursorposition = cursorposition + 3
        } else if (cursorposition == 11) {
            cursorposition = cursorposition + 1
        } else if (cursorposition >= 12) {
            cursorposition = cursorposition
        }

        var txtRange = object.createTextRange();
        txtRange.moveStart("character", cursorposition);
        txtRange.moveEnd("character", cursorposition - object.value.length);
        txtRange.select();
    }

}

function ParseChar(sStr, sChar) {
    if (sChar.length == null) {
        zChar = new Array(sChar);
    } else zChar = sChar;

    for (i = 0; i < zChar.length; i++) {
        sNewStr = "";

        var iStart = 0;
        var iEnd = sStr.indexOf(sChar[i]);

        while (iEnd != -1) {
            sNewStr += sStr.substring(iStart, iEnd);
            iStart = iEnd + 1;
            iEnd = sStr.indexOf(sChar[i], iStart);
        }
        sNewStr += sStr.substring(sStr.lastIndexOf(sChar[i]) + 1, sStr.length);

        sStr = sNewStr;
    }

    return sNewStr;
}

//End of phonenumber textfield validation


     

function setNumbers(event)
{
  const element = event.target;
  var valText = element.value.toString();
  var valTextNewProto = '';
  var valTextNewFinal;
  var valTextLength;
  var valTextHalv1;
  var valTextHalv2;



  valTextLength = valText.length;

  
  for(var i1 = 0; i1 < valTextLength; i1++)
  {
    var i2 = i1 + 1;
    const valChar = valText.substring(i1, i2);

    if(valChar == '0' || valChar == '1' || valChar == '2' || valChar == '3' || valChar == '4' || valChar == '5' || valChar == '6' || valChar == '7' || valChar == '8' || valChar == '9')
    {
      valTextNewProto += valChar;

    }

  }


  valTextLength = valTextNewProto.length;

  if(valTextLength > 3)
  {
    valTextHalv1 = valTextNewProto.substr(0, 3);
    valTextHalv2 = valTextNewProto.substr(3, valTextLength);

    valTextNewFinal = valTextHalv1 + ' ' + valTextHalv2;

  }
  else
  {
    valTextNewFinal = valTextNewProto;

  }


  element.value = valTextNewFinal;

}
$(function(){
    $.ajax({
        url: "/bobot/getKriteria",
        type: 'GET',
        success: function (data) {
            $('#kriteria1').text(data.kriteria1);
            $('#kriteria2').text(data.kriteria2);
            $('#kriteria3').text(data.kriteria3);
            $('#kriteria4').text(data.kriteria4);
        }
    });

});
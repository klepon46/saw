$(function() {

    $("#grid-basic").bootgrid({
            ajax: false,
            templates: { search: "", actions: "", pagination: "", paginationItem: "", footer: "" }
    });

    var year = $('#year').text();
    var period = $('#kuartal').text();

    $.ajax({
        url: "/perhitungan/peringkatFilter?kuartal="+period+"&year="+year,
        type: 'GET',
        success: function (data) {
            $("#grid-basic").bootgrid('append', data);
            window.print();
        }
    });


});
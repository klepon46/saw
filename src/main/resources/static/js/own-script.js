$(function() {

    $.ajax({
        url: "/bobot/getKriteria",
        type: 'GET',
        success: function (data) {
            $('#kriteria1').text(data.kriteria1);
            $('#kriteria2').text(data.kriteria2);
            $('#kriteria3').text(data.kriteria3);
            $('#kriteria4').text(data.kriteria4);

            $('#txtKrit1').attr("placeholder","Masukkan Nilai " + data.kriteria1);
            $('#txtKrit2').attr("placeholder","Masukkan Nilai " + data.kriteria2);
            $('#txtKrit3').attr("placeholder","Masukkan Nilai " + data.kriteria3);
            $('#txtKrit4').attr("placeholder","Masukkan Nilai " + data.kriteria4);

            $("#grid-basic").bootgrid({
                ajax: false,
                templates : {},

                formatters: {
                    "commands": function (column, row) {
                        return "<button type=\"button\" class=\"btn btn-xs btn-danger command-view\" data-row-id=\"" + row.nik + "\"><span class=\"fas fa-trash-alt\"></span></button> &nbsp"
                            + "<button type=\"button\" class=\"btn btn-xs btn-warning command-edit\" data-row-id=\"" + row.nik + "\"><span class=\"fas fa-pencil-alt\"></span></button>";
                    }
                }
            }).on("loaded.rs.jquery.bootgrid", function () {
                  /* Executes after data is loaded and rendered */
                  $("#grid-basic").find(".command-edit").on("click", function (e) {
                      var val = $(this).data("row-id");
                      var url = '/ListData/getDataByNik?' + 'nik=' + val;

                      $.ajax({
                          url: url,
                          type: 'GET',
                          success: function (data) {

                              $('#modalTambahData').modal('show');
                              $('#txtNik').val(data.nik);
                              $('#txtNik').prop("readonly",true);

                              $('#txtNama').val(data.nama);
                              $('#txtNama').prop("readonly",true);

                              $('#txtKrit1').val(data.kriteria1);
                              $('#txtKrit2').val(data.kriteria2);
                              $('#txtKrit3').val(data.kriteria3);
                              $('#txtKrit4').val(data.kriteria4);

                          }
                      });
                  }).end().find(".command-view").on("click", function (e) {
                      var val = $(this).data("row-id");
                      var url = '/ListData/deleteData?nik='+val;

                      $.ajax({
                            url: url,
                            type: 'GET',
                            success: function (data) {
                                alert('Data berhasil dihapus');
                                location.reload();
                            }
                      });

                  });
            });

            $.ajax({
                url: "/ListData/getAllData",
                type: 'GET',
                success: function (data) {
                    $("#grid-basic").bootgrid('append', data);
                }
            });
        }
    });


    $('#filter').click(function() {


          var year = $('#YearFullid').children("option:selected").val();
          var period = $('#period').children("option:selected").val();

          var urlFilter = "/ListData/getDataByFilter?kuartal=" +period+"&year="+year;

          $.ajax({
               url: urlFilter,
               type: 'GET',
                success: function (data) {
                    $("#grid-basic").bootgrid('clear', data);
                    $("#grid-basic").bootgrid('append', data);
                }
          });

    });

    $('#txtNik').focusout(function() {
        console.log($(this).val());
        var val = $(this).val();

        $.ajax({
            url: '/ListData/cekNik?nik='+val,
            type: 'GET',
            success: function (data) {
                if(data == 'ada'){
                    alert('Nik sudah terdaftar');
                    $('#txtNik').focus();
                }
            }
        });

    });

    var status = $('#status').text();
    if(status.length > 0){
        $('#modalTambahData').modal();
    }

});
$(function() {

$("#grid-basic").bootgrid({
    ajax: false,

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
          var url = '/ListData/deleteData';

          console.log(val);

          $.ajax({
                url: url,
                type: 'POST',
                data: { "nik": val },
                success: function (data) {
                    alert('Data berhasil dihapus');
                    location.reload();
                }
          });

      });
});

$.ajax({
    url: "/ListData/getAllPerson",
    type: 'GET',
    success: function (data) {
        console.log('ayam', data);
    }
});

$.ajax({
    url: "/ListData/getAllData",
    type: 'GET',
    success: function (data) {
        console.log('kuda', data);
        $("#grid-basic").bootgrid('append', data);
    }
});

});
var _restEndpoint = '/api/airplaneData/';
var _tableElement = $('#airplaneTable');
var _deleteElement = $('#btndelete');

// Define Modal
var _modalElement = $('#entryModal');

// Define add Dish button
var _dishButton = $('#addDataBtn');

var _dataTable = _tableElement.DataTable({
    ajax: {
        url: _restEndpoint,
        dataSrc: "",
        type: "GET",
    },
});


_dishButton.on('click', function(){
    openModalForObject({},true);
});


_tableElement.on('click', 'tr', function () {
    var data = _dataTable.row(this).data();

    if(!data) {
        console.error('unable to retrieve data');
        return;
    }

    $.get(_restEndpoint + data.id, function(data) {
        if(!data) return;

        openModalForObject(data, false);
    });
});

function openModalForObject(data,newEntry) {
    var _nameField = _modalElement.find('#name');
    var _valueField = _modalElement.find('#value');
    var _ageField = _modalElement.find('#age');

    if(!newEntry){
        _nameField.val(data.name);
        _valueField.val(data.value);
        _ageField.val(data.age);
    }else{
        _nameField.val("");
        _valueField.val("");
        _ageField.val("");
    }

    if(newEntry){
        _modalElement.find('#modal-title').html('New Data')
    }else{
        _modalElement.find('#modal-title').html('Edit Data');
    }

    _modalElement.find('#btnsubmit')
    .off('click')
    .on('click', function() {


        if(newEntry){
            var saveData = {
                name: _nameField.val(),
                value: _valueField.val(),
                age: _ageField.val()
            };
        }else{
            var saveData = {
                id: data.id,
                name: _nameField.val(),
                value: _valueField.val(),
                age: _ageField.val()
            };
        }



        $.ajax({
            contentType : 'application/json',
            url: _restEndpoint,
            type: 'post',
            data: JSON.stringify(saveData),
            success: function() {
                _modalElement.modal('hide');
                reloadData();
            },
        });
    });

    if(!newEntry){
        _modalElement.find('#btndelete').show()
        .off('click')
        .on('click', function() {
            var result = confirm('this action can not be undone');

            if(result) {
                $.ajax({
                    contentType : 'application/json',
                    url: _restEndpoint + data.id,
                    type: 'delete',
                    success: function() {
                        _modalElement.modal('hide');
                        reloadData();
                    },
                });
            }
        });
    }
    _modalElement.modal('show');
    if(newEntry){
        _deleteElement.hide();
    }else{
        _deleteElement.show();
    }
}

function reloadData() {
    _dataTable.ajax.reload();
}

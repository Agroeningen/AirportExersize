var _restEndpoint = '/api/airplaneData/';
var _tableElement = $('#airplaneTable');
var _deleteElement = $('#btndelete');

// Define Modal
var _modalElement = $('#entryModal');

// Define add airplane button
var _airplaneButton = $('#addAirplaneBtn');

// Define refuel airplane button
var _refuelAllButton = $('#refuelAirplaneBtn');

var _dataTable = _tableElement.DataTable({
    ajax: {
        url: _restEndpoint,
        dataSrc: "",
        type: "GET",
    },
});


_airplaneButton.on('click', function(){
    openModalForObject({},true);
});

_refuelAllButton.on('click', function(){
    refuelAllAirplane();
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
function refuelAllAirplane(){
    status: _statusField.val(300)
}

function openModalForObject(data,newEntry) {
    var _nameField = _modalElement.find('#name');
    var _typeField = _modalElement.find('#type');
    var _statusField = _modalElement.find('#status');
    var _fuelField = _modalElement.find('#fuel');
    var _passengersField = _modalElement.find('#passengers');


    if(!newEntry){
        _nameField.val(data.name);
        _typeField.val(data.type);
        _statusField.val(data.status);
        _fuelField.val(data.fuel);
        _passengersField.val(data.passengers);
    }else{
        _nameField.val("");
        _typeField.val("");
        _statusField.val("");
        _fuelField.val("");
        _passengersField.val("");
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
                type: _typeField.val(),
                status: _statusField.val(),
                fuel: _fuelField.val(),
                passengers: _passengersField.val()
            };
        }else{
            var saveData = {
                id: data.id,
                name: _nameField.val(),
                type: _typeField.val(),
                status: _statusField.val(),
                fuel: _fuelField.val(),
                passengers: _passengersField.val()
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

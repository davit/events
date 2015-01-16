$( document ).ready(function(){        
    $('#add-user').on('click', addNewRow);
    $('.table').on('keyup', 'tr', function(e) {                        
        $(this).addClass("edited");        
        var saved = $('.success');
        if (saved.is(":visible")) {
            saved.hide();
        }
    });
    
    $('#save-changes').click(saveChanges);
}); 

var addNewRow = function() {
    var newRowStr = '<tr data-user-status="new"><td class="user" contenteditable="true"</td></tr>';   
    $('.table').append(newRowStr);
};

var saveChanges = function() {  
    var jsonArray = [];
    
    $('.edited').each(function() {
        var userName = $(this).first('td').text().trim();        
        if (userName.length !== 0) {
            var jsonObj = {};
            if ($(this).data('user-status') === 'new') {            
                jsonObj['status'] = 'new';
            }else {
                jsonObj['status'] = 'old';
            }
            jsonObj['id'] = $(this).data('userid');
            jsonObj['user'] = userName;
        }
        jsonArray.push(jsonObj);        
    });

    $.post('user/edit', {"users": JSON.stringify(jsonArray)}, function(response) {          
        $('.success').show();
    });
};
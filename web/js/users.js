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
    var newRowStr = '<tr data-user-status="new"><td class="user" contenteditable="true"</td>\n\
                        <td><input placeholder="Enter password" type="password"></td></tr>';   
    $('.table').append(newRowStr);
};

var saveChanges = function() {  
    var jsonArray = [];
    
    $('.edited').each(function() {
        var userName = $(this).first('td').text().trim();                  
        if (userName.length !== 0) {
            var jsonObj = {};
            if ($(this).data('user-status') === 'new') { 
                var password = $(this).first('td').find('input').val().trim();
                jsonObj['status'] = 'new';
                jsonObj['password'] = password;
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
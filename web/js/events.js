$( document ).ready(function(){        
    $('#add-event').on('click', addNewRow);
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
    var newRowStr = '<tr data-event-status="new"><td class="event" contenteditable="true"</td>'; 
    $('.table').append(newRowStr);
};

var saveChanges = function() {  
    var jsonArray = [];
    
    $('.edited').each(function() {
        var userName = $(this).first('td').text().trim();                  
        if (userName.length !== 0) {
            var jsonObj = {};
            if ($(this).data('event-status') === 'new') {                 
                jsonObj['status'] = 'new';
            }else {
                jsonObj['status'] = 'old';
            }
            jsonObj['id'] = $(this).data('eventId');
            jsonObj['event'] = userName;
        }
        jsonArray.push(jsonObj);        
    });

    $.post('event/edit', {"cities": JSON.stringify(jsonArray)}, function(response) {          
        $('.success').show();
    });
};
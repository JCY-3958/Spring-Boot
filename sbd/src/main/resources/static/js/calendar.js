document.addEventListener('DOMContentLoaded', function() {
    var calendarEl = document.getElementById('calendar');
    var request =  $.ajax({
        url: "/calendar/event",
        method: "GET",
    });
    request.done(function(data) {
        var calendar = new FullCalendar.Calendar(calendarEl, {
            initialView: 'dayGridMonth',
            events: data
        });
        calenar.render();
    });

});
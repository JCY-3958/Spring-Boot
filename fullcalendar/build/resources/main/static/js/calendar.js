document.addEventListener('DOMContentLoaded', function() {
    var calendarEl = document.getElementById('calendar');
    var currentDate = new Date();
    var selectedDate = 0;

    var calendar = new FullCalendar.Calendar(calendarEl, {
        selectable: true,
        dateClick: function(info) {
            if(info.dateStr == selectedDate) {
                window.open('/calendar/add?date='+info.dateStr,'_self');
            }
            selectedDate = info.dateStr;

        },
        eventClick: function(info) {
            var eventObj = info.event;

            if (eventObj.id) {
                window.open(`/calendar/note/${info.event.id}`, '_self');
            }
        },
        initialDate: currentDate,
        dayMaxEvents: true,
        events:'http://localhost:8080/api/notes'

    });

    calendar.render();
});
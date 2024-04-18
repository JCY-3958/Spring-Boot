document.addEventListener('DOMContentLoaded', function() {
    var calendarEl = document.getElementById('calendar');
    var currentDate = new Date();

    var calendar = new FullCalendar.Calendar(calendarEl, {
        selectable: true,
        dateClick: function(info) {
            window.open('/calendar/add?date='+info.dateStr,'_self');
        },
        eventClick: function(info) {
            var eventObj = info.event;

            if (eventObj.url) {
                alert(
                    'Clicked ' + eventObj.title + '.\n' +
                    'Will open ' + eventObj.url + ' in a new tab'
                );

                window.open(eventObj.url);

                info.jsEvent.preventDefault(); // prevents browser from following link in current tab.
            } else {
                alert('Clicked ' + eventObj.title);
            }
        },
        initialDate: currentDate,
        events:'http://localhost:8080/api/notes'

    });

    calendar.render();
});

//select: function(info) {
//             alert('selected ');
//             var nowDate = moment(info.start).format('YYYY-MM-DD');
//             console.log(nowDate);
//             $.ajax({
//                 url: '/calendar/add',
//                 data: { nowDate: nowDate },
//                 success: function(response) {
//                     console.log('Date sent successfully:', response);
//                 },
//                 error: function(xhr, status, error) {
//                     console.error('Error sending date:', error);
//                 }
//             });
//         },
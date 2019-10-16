$(document).ready(function() {
    document.addEventListener('DOMContentLoaded', function() {
        var dropdown = document.querySelectorAll('select');
        M.FormSelect.init(dropdown, {});
        var datepicker = document.querySelectorAll('.datepicker');
        M.Datepicker.init(datepicker, {});
    });
});

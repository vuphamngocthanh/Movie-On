$(document).ready(function() {
    $('#summernote').summernote({
        callbacks: {
            onFocus: function (contents) {
                if($('.summernote').summernote('isEmpty')){
                    $(".summernote").html('');
                }
            }
        },
        placeholder: 'Hello stand alone ui',
        tabsize: 1,
        minHeight: 100,
        maxHeight: 200,
        height: 150,
        toolbar: [
            ['style', ['style']],
            ['font', ['bold', 'italic', 'underline', 'clear']],
            ['fontname', ['fontname']],
            ['color', ['color']],
            ['para', ['ul', 'ol', 'paragraph']],
            ['height', ['height']],
            ['insert', ['link', 'picture', 'hr']],
            ['help', ['help']]
        ],
    });
});
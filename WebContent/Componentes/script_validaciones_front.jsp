<script>
    $(document).ready(function() {
        $('#contrase�a, #contrase�a2').on('keyup', function() {
            var contrase�a = $('#contrase�a').val();
            var contrase�a2 = $('#contrase�a2').val();
            if (contrase�a != contrase�a2) {
                $('#contrase�aError').text('Las contrase�as no coinciden').show();
            } else {
                $('#contrase�aError').text('').hide();
            }
        });
    });
</script>
<script>
    $(document).ready(function() {
        $('#contraseņa, #contraseņa2').on('keyup', function() {
            var contraseņa = $('#contraseņa').val();
            var contraseņa2 = $('#contraseņa2').val();
            if (contraseņa != contraseņa2) {
                $('#contraseņaError').text('Las contraseņas no coinciden').show();
            } else {
                $('#contraseņaError').text('').hide();
            }
        });
    });
</script>
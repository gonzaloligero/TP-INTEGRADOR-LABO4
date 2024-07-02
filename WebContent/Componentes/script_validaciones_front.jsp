<script>
    $(document).ready(function() {
        $('#contraseña, #contraseña2').on('keyup', function() {
            var contraseña = $('#contraseña').val();
            var contraseña2 = $('#contraseña2').val();
            if (contraseña != contraseña2) {
                $('#contraseñaError').text('Las contraseñas no coinciden').show();
            } else {
                $('#contraseñaError').text('').hide();
            }
        });
    });
</script>
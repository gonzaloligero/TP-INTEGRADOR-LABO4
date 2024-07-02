    <script type="text/javascript">
    $(document).ready(function() {
        $('#table_id').DataTable({
            "language": {
                "search": "Buscar:",
                "lengthMenu": "Mostrar _MENU_ registros por página",
                "zeroRecords": "No se encontraron registros coincidentes",
                "info": "Mostrando página _PAGE_ de _PAGES_",
                "infoEmpty": "No hay registros disponibles",
                "infoFiltered": "(filtrado de _MAX_ registros totales)",
                "paginate": {
                    "next":       "Siguiente",
                    "previous":   "Anterior"
                }
            },
            "paging": true,
            "searching": true,
        });
    });
	</script>
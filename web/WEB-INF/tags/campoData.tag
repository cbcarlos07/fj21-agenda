


<%@attribute name="id" required="true" %>
<input id="${id}" name="${id}" type="text"/>
<script type="text/javascript">
  $( function() {
    $("#{id}").datepicker({dateFormat: 'dd/mm/yy'});
  } );
  </script>

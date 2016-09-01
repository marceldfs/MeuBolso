<%@ tag language="java" pageEncoding="ISO-8859-1"%>
<%@ attribute name="id" required="true"%>
<input class="w3-input w3-border w3-round" type="text" id="${id}" name="${id}" />
<script>
	$("#${id}").datepicker({dateFormat: 'dd/mm/yy', changeMonth:true, changeYear:true});
</script>
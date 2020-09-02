<%@page language="java"%>
<%@taglib prefix="jstl" uri ="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir ="/WEB-INF/tags"%>


<acme:form>
	<acme:form-textbox code="entrepreneur.investment-round.form.label.title" path="title" />
	<acme:form-textbox code="entrepreneur.investment-round.form.label.ticker" path="ticker" />
	<acme:form-url code="entrepreneur.investment-round.form.label.additionalInfo" path="additionalInfo" />
	<acme:form-moment code="entrepreneur.investment-round.form.label.creationDate" path="creationDate" />
	<acme:form-select code="entrepreneur.investment-round.form.label.roundKind" path="roundKind">>
		<acme:form-option code="entrepreneur.investment-round.form.label.kind.angel" value="ANGEL" />
		<acme:form-option code="entrepreneur.investment-round.form.label.kind.seeed" value="SEED" />
		<acme:form-option code="entrepreneur.investment-round.form.label.kind.sa" value="SERIES-A" />
		<acme:form-option code="entrepreneur.investment-round.form.label.kind.sb" value="SERIES-B" />
		<acme:form-option code="entrepreneur.investment-round.form.label.kind.sc" value="SERIES-C" />
		<acme:form-option code="entrepreneur.investment-round.form.label.kind.bridge" value="BRIDGE" />
	</acme:form-select>
	<acme:form-money code="entrepreneur.investment-round.form.label.amount" path="amount" />
	<acme:form-textarea code="entrepreneur.investment-round.form.label.description" path="description" />
	<a href="<jstl:url value="/entrepreneur/activity/list">
	<jstl:param name = "roundId" value = "${id}"/>
	</jstl:url>"><h1 style="color:DodgerBlue;"><acme:message code="entrepreneur.investment-round.form.workProgramme"/></h1></a>
	
	<acme:form-submit test="${command == 'create' }" code="entrepreneur.investment-round.form.button.create" 
	action = "/entrepreneur/investment-round/create"/>
	<acme:form-submit test="${command == 'show' }" code="entrepreneur.investment-round.form.button.update" 
	action = "/entrepreneur/investment-round/update"/>
	<acme:form-submit test="${command == 'show' }" code="entrepreneur.investment-round.form.button.delete" 
	action = "/entrepreneur/investment-round/delete"/>
	<acme:form-submit test="${command == 'update' }" code="entrepreneur.investment-round.form.button.update" 
	action = "/entrepreneur/investment-round/update"/>
	<acme:form-submit test="${command == 'delete' }" code="entrepreneur.investment-round.form.button.delete" 
	action = "/entrepreneur/investment-round/delete"/>
	<acme:form-return code="entrepreneur.investment-round.form.button.return"/>
</acme:form>
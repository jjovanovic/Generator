
<#function checkType testSting>
	<#if testSting == "EDate" || testSting == "EBoolean">
  	<#return testSting?substring(1)>
  	<#else>
  	<#return testSting>
  	</#if>
</#function>

<#function mandatory value>
	<#if value>
  	<#return false>
  	<#else>
  	<#return true>
  	</#if>
</#function>
package beans;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "${class.name}")
${class.visibility} class ${class.name} <#if class.parent?exists>extends ${class.parent.name}</#if>{

	<#list class.properties as property>
	<#if property.dbProperty?exists>
		<#if property.dbProperty.id>
	@Id
    @GeneratedValue
		</#if>
	@Column(name = "${property.name}", unique = "${property.dbProperty.unique?c}", nullable = "${mandatory(property.dbProperty.mandatory)?c}")
	private ${checkType(property.type)} ${property.name};
	</#if>
	<#if !property.dbProperty?exists>
    	<#if property.upper == 100>
  	@OneToMany(cascade = {CascadeType.ALL}, fetch = FetchType.LAZY, mappedBy = "${class.name?lower_case}")
    private Set<${property.type}> ${property.name};
    	</#if>	
    @ManyToOne
    @JoinColumn(name="${property.name}", unique = "false", nullable = "false")
    private ${property.type} ${property.name};
	</#if>
	
	</#list>
	public ${class.name}() {
        super();
    }
    <#list class.properties as property>
	
	<#if property.upper == 100>
	${property.visibility} Set<${property.type}> get${property.name?cap_first}(){
		return ${property.name};
	}
	
	${property.visibility} void set${property.name?cap_first}(Set<${property.type}> ${property.name}){
		this.${property.name} = ${property.name};
	}
	<#else>
	${property.visibility} ${checkType(property.type)} get${property.name?cap_first}(){
		return ${property.name};
	}
	
	${property.visibility} void set${property.name?cap_first}(${checkType(property.type)} ${property.name}){
		this.${property.name} = ${property.name};
	}
	</#if>
	</#list>
}
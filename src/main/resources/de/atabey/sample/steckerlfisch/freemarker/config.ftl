<#ftl>
<#import "/spring.ftl" as spring />
<#-- @ftlvariable name="environment" type="org.springframework.core.env.Environment" -->

<h1>Spring Environment Abstraction</h1>
<h2>Profiles</h2>
Active profiles:
<ul>
<#list environment.activeProfiles as profile>
    <li>${profile}</li>
</#list>
</ul>
<br/>
Default profiles:
<ul>
<#list environment.defaultProfiles as profile>
    <li>${profile}</li>
</#list>
</ul>

maxLimit: <#if maxLimit?exists>${maxLimit}</#if>
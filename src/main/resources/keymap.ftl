<#if layout??>Layout is filled</#if>
<#if layout.layers??>layers also filled</#if>

<#list layout.layers?keys as layer>
LayerName: ${layer}

[${layer}]=<#list layout.layers[layer].layout as l><#if l.skip><#else>${l.value!}<#sep>,</#if></#list>
</#list>
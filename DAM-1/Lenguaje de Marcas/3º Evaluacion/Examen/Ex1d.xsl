<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:template match="/">
        <html>
            <body>
                <xsl:for-each select="operaciones">
                    <h2>
                        <u><xsl:value-of select="@tienda"/><br/></u>
                    </h2>
                </xsl:for-each>
                <table border="1">
                    <tr bgcolor="yellow">
                        <th>Titulos de libros comprados</th>
                        <th>Proveedor</th>
                        <th>Fecha</th>
                    </tr>
                    <xsl:for-each select="operaciones/operacion/compra/tituloscomprados">
                        <tr>
                            <td>
                                <xsl:value-of select="titulo"/>
                            </td>
                            <td>
                                <xsl:value-of select="proveedor"/>
                            </td>  
                            <td>
                                <xsl:value-of select="fechacompra/dia"/>  
                                <xsl:value-of select="fechacompra/mes"/> 
                                <xsl:value-of select="fechacompra/anio"/>
                            </td>                                                                        
                        </tr>
                    </xsl:for-each>
                </table><br/>                
                <table border="1">
                    <tr bgcolor="yellow">
                        <th>Camtidad total</th>
                        <th>Titulos de libros vendidos</th>
                        <th>Precio total</th>
                        <th>Moneda</th>
                    </tr>
                    <xsl:for-each select="operaciones/operacion/venta/titulosvendidos">
                    <xsl:choose>
                    <xsl:when test="cantidadtotal&gt;800">
                        <tr>
                            <td>
                                <xsl:value-of select="cantidadtotal"/>
                            </td>
                            <td bgcolor="red">
                                <xsl:value-of select="titulo"/>
                            </td>  
                            <td>
                                <xsl:value-of select="importe"/>
                            </td>
                            <td>
                                <xsl:value-of select="importe/@moneda"/>
                            </td>                                                                         
                        </tr>
                    </xsl:when>
                    <xsl:otherwise>
                        <tr>
                            <td>
                                <xsl:value-of select="cantidadtotal"/>
                            </td>
                            <td bgcolor="green">
                                <xsl:value-of select="titulo"/>
                            </td>  
                            <td>
                                <xsl:value-of select="importe"/>
                            </td>
                            <td>
                                <xsl:value-of select="importe/@moneda"/>
                            </td>                                                                         
                        </tr>
                    </xsl:otherwise>
                    </xsl:choose>                                            
                    </xsl:for-each>
                </table>                
            </body>
        </html>
    </xsl:template>
</xsl:stylesheet>
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
                        <th>Camtidad total</th>
                        <th>Titulos de libros vendidos</th>
                        <th>Precio total</th>
                        <th>Moneda</th>
                    </tr>
                    <xsl:for-each select="operaciones/operacion/venta/titulosvendidos">
                    <xsl:sort select="@moneda='euro'"/>                    
                    <xsl:if test="importe/@moneda='euros'">
                        <tr>
                            <td>
                                <xsl:value-of select="cantidadtotal"/>
                            </td>
                            <td>
                                <xsl:value-of select="titulo"/>
                            </td>  
                            <td>
                                <xsl:value-of select="importe"/>
                            </td>
                            <td>
                                <xsl:value-of select="importe/@moneda"/>
                            </td>                                                                         
                        </tr>
                    </xsl:if>
                    </xsl:for-each>
                </table>                
            </body>
        </html>
    </xsl:template>
</xsl:stylesheet>
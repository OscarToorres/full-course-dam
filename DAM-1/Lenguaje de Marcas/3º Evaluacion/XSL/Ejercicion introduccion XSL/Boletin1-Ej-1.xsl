<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:template match="/">
        <html>
            <body>
                <h3>COLECCION DE LIBROS</h3>
                <table border="1">
                    <tr bgcolor="#CCFFFF">
                        <th style="text-aling:left">titulo</th>
                        <th style="text-aling:left">autor</th>
                        <th style="text-aling:left">año</th>
                        <th style="text-aling:left">paginas</th>
                    </tr>
                    <xsl:for-each select="coleccion/libros">
                        <tr>
                            <td>
                                <xsl:value-of select="titulo"/>
                            </td>
                            <td>
                                <xsl:value-of select="autor"/>
                            </td>                      
                            <td>
                                <xsl:value-of select="año"/>
                            </td>
                            <td>
                                <xsl:value-of select="paginas"/>
                            </td>
                        </tr>
                    </xsl:for-each>
                </table>
            </body>
        </html>
    </xsl:template>
</xsl:stylesheet>
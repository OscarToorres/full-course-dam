<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:template match="/">
        <html>
            <body>
                <h3>CICLOS</h3>
                <table border="1">
                    <tr bgcolor="#CCFFFF">
                        <th style="text-aling:left">nombre</th>
                        <th style="text-aling:left">grado</th>
                        <th style="text-aling:left">decretoTitulo</th>
                    </tr>
                    <xsl:for-each select="ies/ciclos/ciclo">
                        <tr>
                            <td>
                                <xsl:value-of select="nombre"/>
                            </td>
                            <td>
                                <xsl:value-of select="grado"/>
                            </td>                      
                            <td>
                                <xsl:attribute name="año">
                                    <xsl:value-of match="decretoTitulo"/>
                                </xsl:attribute>
                            </td>
                        </tr>
                    </xsl:for-each>
                </table>
            </body>
        </html>
    </xsl:template>
</xsl:stylesheet>
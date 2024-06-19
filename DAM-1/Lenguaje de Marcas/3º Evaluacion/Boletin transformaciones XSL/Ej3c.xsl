<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:template match="/">
        <html>
            <body>
                <h3>Equipos de: 
                    <xsl:for-each select="equipos_de_futbol">
                        <xsl:value-of select="@pais"/>
                    </xsl:for-each>
                </h3>
                <table border="1">
                    <tr bgcolor="green">
                        <th>Equipo:</th>
                        <th>Ciudad:</th>
                        <th>Entrenador:</th>
                    </tr>
                    <xsl:for-each select="equipos_de_futbol/equipo">
                        <tr>
                            <td>
                                <xsl:value-of select="nombre"/>
                            </td>
                            <td>
                                <xsl:value-of select="ciudad"/>
                            </td>
                            <td>
                                <xsl:value-of select="entrenador"/>
                            </td>                      
                        </tr>
                    </xsl:for-each>
                </table>                
            </body>
        </html>
    </xsl:template>
</xsl:stylesheet>
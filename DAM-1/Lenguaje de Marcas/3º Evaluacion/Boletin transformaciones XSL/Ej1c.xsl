<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:template match="/">
        <html>
            <body>
                <xsl:for-each select="ies">
                    <h1>
                        <xsl:value-of select="@nombre"/><br/>
                    </h1>
                </xsl:for-each>
                <table border="1">
                    <tr>
                        <td>Nombre del ciclo</td>
                        <td>Grado</td>
                        <td>Año del titulo</td>
                    </tr>
                    <xsl:for-each select="ies/ciclos/ciclo">
                    <xsl:choose>
                    <xsl:when test="decretoTitulo/@ano&gt;2009">
                    <tr>
                        <td bgcolor="blue">
                            <font color="white">
                                <xsl:value-of select="nombre"/>
                            </font>
                        </td>
                        <td>
                            <xsl:value-of select="grado"/>
                        </td>
                        <td>
                            <xsl:value-of select="decretoTitulo/@ano"/>
                        </td>                                                
                    </tr>
                    </xsl:when>
                    <xsl:otherwise>
                    <tr>
                        <td bgcolor="red">
                            <xsl:value-of select="nombre"/>
                        </td>
                        <td>
                            <xsl:value-of select="grado"/>
                        </td>
                        <td>
                            <xsl:value-of select="decretoTitulo/@ano"/>
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
<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:template match="/">
        <html>
            <body>
                <xsl:for-each select="catalog">
                    <h2><b><u><xsl:value-of select="@titulo"/></u></b></h2>
                </xsl:for-each>
                <table border="1">
                    <tr bgcolor="green">
                        <th>Titulo del disco</th>
                        <th>Cantante</th>
                    </tr>
                    <xsl:for-each select="catalog/cd">
                    <xsl:sort select="artist"/>
                        <tr>
                            <td>
                                <xsl:value-of select="title"/>
                            </td>
                            <td>
                                <xsl:value-of select="artist"/>
                            </td>
                            <td>
                                <xsl:value-of select="price"/>
                            </td>                    
                        </tr>
                    </xsl:for-each>
                </table>                
            </body>
        </html>
    </xsl:template>
</xsl:stylesheet>
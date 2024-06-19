<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:template match="/">
        <html>
            <body>
                <xsl:for-each select="ies">
                    <h1>
                        <xsl:value-of select="@nombre"/><br/>
                    </h1>
                    <h3>De grado Superior son:</h3>
                </xsl:for-each>
                <xsl:for-each select="ies/ciclos/ciclo">
                <xsl:if test="grado='Medio'">
                <ul>
                    <li><xsl:value-of select="@id"/><br/>
                        <u><xsl:value-of select="nombre"/></u>
                    </li>
                </ul>
                </xsl:if>
                </xsl:for-each>
            </body>
        </html>
    </xsl:template>
</xsl:stylesheet>
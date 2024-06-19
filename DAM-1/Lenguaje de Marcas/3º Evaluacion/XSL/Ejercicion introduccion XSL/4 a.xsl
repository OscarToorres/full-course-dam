<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
    <xsl:template match="/">
        <html>
                <xsl:for-each select="ies">
                    <h1><xsl:value-of select="nombre"/></h1>
                </xsl:for-each>
                <xsl:for-each select="ies/ciclos/ciclo">
                    <p><xsl:value-of select="nombre"/></p>
                </xsl:for-each>
        </html>
    </xsl:template>
</xsl:stylesheet>
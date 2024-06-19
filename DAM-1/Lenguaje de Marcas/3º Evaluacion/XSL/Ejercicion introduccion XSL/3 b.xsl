<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
    <xsl:template match="/">
        <html>
            <body>
                    <xsl:for-each select="ies">
                <h1><td><xsl:value-of select="@nombre"/></h1>
                    <p>Pagina web a:<a>
                    <xsl:attribute name="href">
                    <xsl:value-of select="@web">
                    </xsl:attribute>
                    <xsl:value-of select="@web">
                    </a></p>
                </xsl:for-each>
            </body>
        </html>
    </xsl:template>
</xsl:stylesheet>
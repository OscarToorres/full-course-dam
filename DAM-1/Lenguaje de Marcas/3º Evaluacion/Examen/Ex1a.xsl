<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:template match="/">
        <html>
            <body>
                <xsl:for-each select="operaciones">
                    <h2>
                        Resultados de operaciones: <xsl:value-of select="@tienda"/><br/>
                    </h2>
                </xsl:for-each>
                <h3>Libros vendidos:</h3>
                <ol>
                <xsl:for-each select="operaciones/operacion/venta/titulosvendidos">
                    <li><xsl:value-of select="titulo"/><br/></li>
                </xsl:for-each>
                </ol>
                <h3>Libros comprados:</h3>
                <ol>
                <xsl:for-each select="operaciones/operacion/compra/tituloscomprados">
                    <li><xsl:value-of select="titulo"/><br/></li>
                </xsl:for-each>                                  
                </ol>
            </body>
        </html>
    </xsl:template>
</xsl:stylesheet>
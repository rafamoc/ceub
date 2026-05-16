# Pasta onde estão os PDFs
$folder = "entrega02/_enviados/"

# Arquivo de saída
$outputFile = "entrega02/_enviados/saida_hashes.txt"

# Calcula os hashes, ordena e grava no TXT
Get-ChildItem -Path $folder -Filter *.xml -File |
ForEach-Object {
    $hash = Get-FileHash $_.FullName -Algorithm SHA256
    [PSCustomObject]@{
        Hash = $hash.Hash
        File = $_.Name
    }
} |
Sort-Object Hash |
ForEach-Object {
    "$($_.Hash)  $($_.File)"
} |
Out-File -Encoding UTF8 $outputFile

Write-Host "Arquivo gerado em: $outputFile"